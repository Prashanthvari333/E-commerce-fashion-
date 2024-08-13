import StarBorderIcon from '@mui/icons-material/StarBorder';
import { Box, Grid } from '@mui/material'
import { deepPurple } from '@mui/material/colors'
import React from 'react'
import AddressCard from '../AddressCard/AddressCard'
import OrderTracker from './OrderTracker'

const OrderDetails = () => {
  return (
    <div className='sm:px-5 lg:px-20'>
        <div className="">
            <h1 className="font-bold text-xl py-7">Delivery Address</h1>
            <AddressCard/>
        </div>

        <div className="py-20">
            <OrderTracker activeStep={2}/>
        </div>
        <Grid container className='space-y-5'>
            {[1,1,1,1,1].map((item)=>
                <Grid item container className='shadow-xl rounded-md p-5 border' 
                sx={{ alignItems:'center',justifyContent:'space-between'}}>
                    <Grid item xs={6}>
                        <div className="flex items-center space-x-4">
                            <img className="w-[5rem] h-[5rem] object-cover object-top " src="https://tse1.explicit.bing.net/th?id=OIP.WyAmenp4gtRDwZwOmAX48wHaJ_&pid=Api&P=0&h=180" alt="" />
                            <div className="space-y-2 ml-5">
                                <p className='font-semibold'> Title of the product</p>
                                <p className='space-x-5 opacity-50 text-xs font-semibold'> <span>Color:pink</span><span>Size:M</span></p>
                                <p>seller:Linaria</p>
                                <p>Rs1099</p>
                            </div>
                        </div>
                    </Grid>
                    <Grid item>
                        <Box sx={{color: deepPurple[500]}}>
                            <StarBorderIcon  sx={{fontSize:'2rem'}}  className='px-2'/>
                            <span>Rate & Review Product</span>
                        </Box>
    
                    </Grid>
    
                </Grid>
            
            )}


        </Grid>
        
    </div>
  )
}

export default OrderDetails