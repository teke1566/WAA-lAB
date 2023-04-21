import React from "react";
import { Link } from 'react-router-dom';
// import logo from '../../assets/logos/miu-logo.png';
import './Header.css'

const Header = () => {

    return (
        <header>
            <nav>
                <ul>
                    <li> <Link to="/posts">Posts</Link> </li>
                    <li> <Link to="/addposts">Add Posts</Link> </li>
                    <li> <Link to="/selected">Selected Posts</Link> </li>
                </ul>
            </nav>
        </header>
    );
}



export default Header;