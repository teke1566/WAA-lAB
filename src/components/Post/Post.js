
import React, { useContext } from 'react';
import { Link } from 'react-router-dom';


const Post = (props) => {

    

    return (
        <Link to={`${props.model.id}`}>
            <div className="Content">
            <p>{props.model.id}</p>
                <h3>{props.model.title}</h3>
                <p>{props.model.author}</p>


                
            </div>
        </Link>
    );
}

export default Post;




