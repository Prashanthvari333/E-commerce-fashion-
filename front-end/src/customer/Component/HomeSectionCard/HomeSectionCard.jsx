import React from 'react';

function HomeSectionCard() {
    return (
        <div className='cursor-point flex flex-col items-center bg-white rounded-lg shadow-lg overflow-hidden w-[15rem] mx-3 border border-black'>
            <div className='h-[13rem] w-[10rem]'>
                <img className="object-cover object-top h-full w-full" src="https://d6kigqwjl9u8w.cloudfront.net/blueskytechco/testimonial/e/z/ezgif-1-b5adb2bdd7.webp" alt="" />
            </div>
            <div className='p-4'>
                <h1 className='text-lg text-gray-900 font-medium'>NoFilter</h1>
                <p className='text-sm text-gray-500'>It is something u need to try</p>
            </div>
        </div>
    );
}

export default HomeSectionCard;