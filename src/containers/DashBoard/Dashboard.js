
import React, { createContext, useState } from 'react';
import '../Headers/Header.css'
import Header from "../Headers/Header";
import PageRoutes from './PageRoutes';
import { SelectedPostContext } from '../../context/SelectedPost';

export default function Dashboard() {

    const [selectPost, setSelectPost] = useState([]);

    return (
        <>
            <SelectedPostContext.Provider value={{ selectPost, setSelectPost }}>
                <div className='header'>
                    <Header />
                </div>
                <div className="Product">
                    <PageRoutes />
                </div>
            </SelectedPostContext.Provider>
        </>

    )

}