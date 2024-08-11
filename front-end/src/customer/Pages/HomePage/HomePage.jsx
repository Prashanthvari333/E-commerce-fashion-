import React from 'react'
import MainCarousel from '../../Component/HomeCarousel/MainCarousel'
import HomeSectionCarousel from '../../Component/HomeSectionCarousel/HomeSectionCarousel';

const HomePage = () => {
  return (
      <div>
        <div>
            <MainCarousel/>
        </div>
        <div className='space-y-20 py-20 flex flex-col justify-center px-5 lg:px-10'>
            <HomeSectionCarousel/>
            <HomeSectionCarousel/>
            <HomeSectionCarousel/>
            <HomeSectionCarousel/>
            <HomeSectionCarousel/>
        </div>
    </div>
    
  )
}

export default HomePage;