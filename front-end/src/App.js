

 import Cart from './customer/Component/Cart/Cart';
 import Footer from './customer/Component/Footer/Footer';
 import Navigation from './customer/Component/Navigation/Navigation';
 import Product from './customer/Component/Product/Product';
 import ProductDetails from './customer/Component/ProductDetails/ProductDetails';
 import HomePage from './customer/Pages/HomePage/HomePage';
 import Checkout from './customer/Component/Checkout/Checkout';
 import Order from './customer/Order/Order';
import OrderDetails from './customer/Order/OrderDetails';
import './App.css';
import { Route, Routes } from 'react-router-dom'
import CustomerRoutes from './Routes/CustomerRoutes';

function App() {
  return (
    <div>
       <Routes>
         <Route path='/*' element={<CustomerRoutes/>}></Route>
       </Routes>
       
            {/* 
        <HomePage/> 
        <Product/>
        <ProductDetails/>
        <Cart/>
        <Checkout/>
        <Order/>
        <OrderDetails/>
        <CustomerRoutes/>
       <Routes>
         <Route path='/*' element={<CustomerRoutes/>}></Route>
       </Routes>
        */}

      </div>
    
  );
}

export default App;
