import React from 'react';
import { Grid } from '@mui/material';
import AdjustIcon from '@mui/icons-material/Adjust';
import { useNavigate } from 'react-router-dom';

const OrderCart = () => {
    const navigate = useNavigate();
    const handelOrderDetails=()=>{
        navigate(`account/order/${5}`)
    }
  return (
    <div onClick={handelOrderDetails} className='p-5 shadow-lg shadow-black hover:shadow-2xl border'>
        <Grid container spacing={2} sx={{justifyContent:'space-between'}}>
            <Grid item xs={6}>
                <div className="flex cursor-pointer">
                    <img className="w-[5rem] h-[5rem] object-cover object-top " src="https://tse1.explicit.bing.net/th?id=OIP.WyAmenp4gtRDwZwOmAX48wHaJ_&pid=Api&P=0&h=180" alt="" />
                    <div className='ml-5 space-y-2'>
                        <p className=''>Men Skin tight Jeans</p>
                        <p className="opacity-50 font-semibold">Size : M</p>
                        <p className="opacity-50 font-semibold">Color: Black</p>
                    </div>
                </div>
            </Grid>

            <Grid item xs={2}>
                <p>Rs. 1999</p>
            </Grid>
            <Grid item xs={4}>
                
                {
                    true ?(<div>
                        <p> <AdjustIcon sx={{ width:'15px' ,height:'15px'}} className='text-green-600 mr-2 text-sm'/>
                            <span>Delivered on Mar 30</span>
                        </p>
                        <p className='text-xs mt-2'>Your Items has been delivered</p>
                    </div>) :(<p><span>Expected Delivery on Mar 30</span></p>)
                }
           
            </Grid>
      </Grid>
        
    </div>
  )
}

export default OrderCart