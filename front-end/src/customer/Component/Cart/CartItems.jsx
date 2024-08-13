import { Button, IconButton } from '@mui/material'
import React from 'react';
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';

const CartItems = () => {
  return (
    <div className='p-5 shadow-lg border rounded-md'>
        <div className="flex items-center">
            <div className="w-[5rem] h-[5rem] lg:w-[9rem] lg:h-[9rem]">
                <img className='w-full h-full object-cover object-top' 
                src="https://tse2.mm.bing.net/th?id=OIP.NPstn4zzzKtDwKsquiyk8QAAAA&pid=Api&P=0&h=180" 
                alt="" />
            </div>
            <div className="ml-5 space-y-1">
                <p className="font-semibold">Men's Fancy Kurtha</p>
                <p className=" opacity-50 ">Size:l, White</p>
                <p className=" opacity-70 mt-2 ">seller: Crishtaliyo 2fashion</p>

                <div className="flex space-x-5 items-center text-lg lg:text-xl text-gray-900 pt-6">
                    <p className='font-semibold'>₹199</p>
                    <p className='opacity-50 line-through'>₹211</p>
                    <p className='text-green-600 font-semibold'>5% off</p>
                </div>
            </div>
            
        </div>

        <div className="lg:flex items-center lg:space-x-10 pt-4">
                    <div className="flex items-center space-x-2">
                        <IconButton>
                            <RemoveCircleOutlineIcon/>
                        </IconButton>
                        <span className='py-1 px-7 border rounded-sm'> 4 </span>
                        <IconButton sx={{color:'purple'}}>
                            <AddCircleOutlineIcon/>
                        </IconButton>  
                        
                    </div>
                    <div className="">
                        <Button sx={{color:'purple'}} >Remove</Button>
                    </div>
         </div>

    </div>
  )
}

export default CartItems