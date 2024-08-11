import { Button } from '@headlessui/react'
import { Grid, Typography } from '@mui/material'
import React from 'react'

const Footer = () => {
  return (
    <div>
        <Grid className='bg-black text-white text-center mt-10'
            container
            sx={{bgcolor:'black',color:'white',py:3}}
        >
            <Grid item xs={12} sm={6} md={3}>
                <Typography className='pb-5' variant='h6'> Company</Typography>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>about</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>blogs</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>jobs</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>press</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>partners</Button>
                </div>
            </Grid>

            <Grid item xs={12} sm={6} md={3}>
                <Typography className='pb-5' variant='h6'> Solutions </Typography>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>marketing</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>Analytics</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>commerce</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>Insights</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>Supports</Button>
                </div>
            </Grid>

            <Grid item xs={12} sm={6} md={3}>
                <Typography className='pb-5' variant='h6'> Documentations</Typography>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>Guides</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>API status</Button>
                </div>
            </Grid>

            <Grid item xs={12} sm={6} md={3}>
                <Typography className='pb-5' variant='h6'> Legal</Typography>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>claim</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>privacy</Button>
                </div>
                <div>
                    <Button className="pb-5" variant='h6' gutterButton>terms</Button>
                </div>
            </Grid>

            
        </Grid>
      
    </div>
  )
}

export default Footer
