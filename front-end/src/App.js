
import './App.css';
import Footer from './customer/Component/Footer/Footer';
import Navigation from './customer/Component/Navigation/Navigation';
import Product from './customer/Component/Product/Product';
import HomePage from './customer/Pages/HomePage/HomePage';

function App() {
  return (
    <div>
      <div>
        <Navigation/>
      </div>
      <div>
        {/* <HomePage/> */}
        <Product/>
      </div>
      <div>
            <Footer/>
      </div> 
    </div>
  );
}

export default App;
