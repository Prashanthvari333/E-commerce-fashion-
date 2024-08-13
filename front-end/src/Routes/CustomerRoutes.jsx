import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Cart from '../customer/Component/Cart/Cart';
import HomePage from '../customer/Pages/HomePage/HomePage';
import Navigation from '../customer/Component/Navigation/Navigation';
import Footer from '../customer/Component/Footer/Footer';
import Product from '../customer/Component/Product/Product';
import ProductDetails from '../customer/Component/ProductDetails/ProductDetails';
import Checkout from '../customer/Component/Checkout/Checkout';
import OrderDetails from '../customer/Order/OrderDetails';
import Order from '../customer/Order/Order';
import SignUp from '../customer/Pages/AuthPages/SignUp';


const CustomerRoutes = () => {
  return (
    <div>
        <div>
            <Navigation/>
        </div>
        <Routes>
            <Route path='/' element={ <HomePage/>}></Route>
            <Route path='/cart' element={ <Cart/>}></Route>
            <Route path='/:levelOne/:levelTwo/:levelThree' element={<Product/>}> </Route>
            <Route path='/product/:productId' element={ <ProductDetails/>}></Route>
            <Route path='/checkout' element={ <Checkout/>}></Route>
            <Route path='/account/order' element={ <Order/>}></Route>
            <Route path='/account/order/:orderId' element={<OrderDetails/>}></Route>
            <Route path='/sign-up' element={<SignUp/>}></Route>
        {/* 

        <Checkout/>
        <Order/>
        <OrderDetails/>
        */}
        </Routes>
        <div>
            <Footer/>
      </div> 
    </div>
  )
}

export default CustomerRoutes