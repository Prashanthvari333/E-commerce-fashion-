import React from 'react'
import AddressCard from '../../AddressCard/AddressCard';
import CartItems from '../Cart/CartItems';
import { Button } from '@mui/material';

const OrderSummary = () => {
  return (
    <div>
        <div className="p-5 shadow-lg rounded-md border">
            <AddressCard/>
        </div>
        <div className=''>
        <div className="lg:grid grid-cols-3 relative">
            <div className='col-span-2 mt-5'>
              {[1,1,1].map((item)=><CartItems/>)}
            </div>
        
            <div className="px-5 sticky top-0 h-[100vh] mt-5 lg:mt-0">
                <div className="border">
                    <p className='uppercase font-bold opacity-60 pb-4'>Price details</p>
                    <hr/>
                    <div className='space-y-3 font-semibold mb-5'>
                        <div className="flex justify-between pt-3 text-black">
                            <span>Price</span>
                            <span >rs. 4697</span>
                        </div>
                        <div className="flex justify-between pt-3 ">
                            <span>Discount</span>
                            <span className='text-green-600'> - rs. 697</span>
                        </div>
                        <div className="flex justify-between pt-3 ">
                            <span>Delivery Charges</span>
                            <span className='text-green-600'>Free</span>
                        </div>
                        <div className="flex justify-between pt-3">
                            <span>Total Amount</span>
                            <span className='text-green-600'>rs. 4000</span>
                        </div>
                    </div>
                    <Button variant='contained' className="w-full mt-5 " sx={{px:'2.5rem' ,py:'0.7rem', bgcolor:'#9155fd'}}>Check Out</Button>
                </div>
            </div>
        </div>
        
    </div>
    </div>
  )
}

export default OrderSummary