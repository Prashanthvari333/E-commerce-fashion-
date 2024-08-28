import React, { useState,useEffect} from 'react';
import { Grid, Typography } from '@mui/material';
import {TextField} from '@mui/material';

import { Button } from '@mui/material';
import {useNavigate} from 'react-router-dom';
import {useDispatch,useSelector} from 'react-redux';
import { getUser, register } from '../../State/Auth/Action';
import { store } from '../../State/store';


const RegisterForm = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");


    const {auth} = useSelector(store => store );
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const jwt = localStorage.getItem("jwt")

    useEffect(()=>{
        if(jwt) {
            dispatch(getUser(jwt));
        }
    },[jwt,auth.jwt])



  const handleSubmit = (e) => {
    e.preventDefault();

    const data = new FormData(e.currentTarget)
    const userData = {
        firstName: data.get('firstName'),
        lastName: data.get('lastName'),
        email : data.get('email'),
        password : data.get('password')
    }

    dispatch(register(userData))
    console.log('Form submitted:', userData);
    // Here you would typically send the data to your backend
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>

        <Grid container spacing ={3} >
            
            <Grid item xs={12} sm={6}>
                <TextField
                required
                id = 'firstName'
                name = 'firstName'
                label = 'First Name'
                fullWidth
                autoComplete = 'given-name'
                />
            </Grid>

            <Grid item xs={12} sm={6}>
                <TextField
                required
                id = 'lastName'
                name = 'lastName'
                label = 'Last Name'
                fullWidth
                autoComplete = 'given-name'
                />
            </Grid>

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
                    Register
                </Button>
            </Grid>


        </Grid>
      </form>

      <div className='flex justify-center flex-col '>
        <div className='py-3 fle items-center flex justify-center flex-col' >
            <div>
            <p className='text-gray-500 text-sm'>Already have an account? </p>
            </div>
            <div>
                <Button onClick = {()=>navigate('/login')}
                className ='ml-5'
                size ='small'
                > Login </Button>
            </div>
           
            
        </div>
      </div>
    </div>
  );
};

export default RegisterForm;
