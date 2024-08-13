import { Button } from '@mui/material';
import KeyboardArrowLeftIcon  from '@mui/icons-material/KeyboardArrowLeft';
import React ,{useState}from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import HomeSectionCard from '../HomeSectionCard/HomeSectionCard';
import {mensKurthas} from '../../Data/Men/Men-Kurtha';
import { homeCarouselData } from './HomeSectionCarouselData';



const responsive = {
    0: { items: 1 },
    720: { items: 3 },
    1024: { items: 5 },
};

const items = mensKurthas.map((item) => <HomeSectionCard product={item} />);

const HomeSectionCarousel = () => {
    const [activeIndex,setActiveIndex] = useState(0);

    const slidePrev=()=>setActiveIndex(activeIndex-1);
    const slideNext=()=>setActiveIndex(activeIndex+1);
    const syncActiveIndex=({item})=>setActiveIndex(item)

    return (
    <div className='relative px-4 lg:px-8 border border-black'>
        {activeIndex !== items.length-5 &&
        <Button variant="contained" className = 'z-50 ' onClick={slideNext}  sx={{position:'absolute',top:'8rem',left:'0rem',transform:'translateX(-50%) rotate(90deg)',bgcolor:"white"  }} aria-label="next">
            <KeyboardArrowLeftIcon  sx={{transform:'rotate(-90deg)', color:"black"}}/>
        </Button>
        }
        <div className='relative p-5'>
            <AliceCarousel
            items={items}
            disableButtonsControls
            disableDotsControls
            responsive={responsive}
            onSlideChanged={syncActiveIndex}
            activeIndex={activeIndex}
            />
        </div>
        { activeIndex !==0 &&
        <Button variant="contained" className = 'z-50 ' onClick={slidePrev} sx={{position:'absolute',top:'8rem',right:'0rem',transform:'translateX(50%) rotate(90deg)',bgcolor:"white"  }} aria-label="next">
            <KeyboardArrowLeftIcon  sx={{transform:'rotate(90deg)', color:"black"}}/>
        </Button>
        }
    </div>

);

    }


export default HomeSectionCarousel;