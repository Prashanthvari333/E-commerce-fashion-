import React, { useState } from 'react';
import { Grid, Typography } from '@mui/material';
import {TextField} from '@mui/material';

import { Button } from '@mui/material';
import {useLocation,useNavigate} from 'react-router-dom';
import {useDispatch} from 'react-redux';
import { login } from '../../State/Auth/Action';

const LoginForm = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();


  const handleSubmit = (e) => {
    e.preventDefault();
    

    const data = new FormData(e.currentTarget)
    const userData = {
        email : data.get('email'),
        password : data.get('password')
    }
    console.log('Form submitted:', userData);
    dispatch(login(userData))
    // Here you would typically send the data to your backend
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>

        <Grid container spacing ={3} >
            


            <Grid item xs={12} sm={12}>
                <TextField
                required
                id = 'email'
                name = 'email'
                label = 'Email'
                fullWidth
                autoComplete = 'given-name'
                />
            </Grid>

            <Grid item xs={12} sm={12}>
                <TextField
                required
                id = 'password'
                name = 'password'
                label = 'Password'
                fullWidth
                autoComplete = 'given-name'
                />
            </Grid>

            <Grid item xs={12} sm={12}>
                <Button
                className ='bg-purple-400 w-full'
                type = 'submit'
                variant = 'contained'
                size = 'large'
                sx = {{padding : '.8rem 0'}}
                >
                    Login
                </Button>
            </Grid>


        </Grid>
      </form>


      <div className='py-3 fle items-center flex justify-center flex-col' >
            <div>
                <p className='text-gray-500 text-sm'> If you don't have account?</p>
            </div>
            <div>
                <Button onClick = {()=>navigate('/signup')}
                className ='ml-5'
                size ='small'
                >  Register </Button>
            </div>
        </div>
      
    </div>
  );
};

export default LoginForm;
