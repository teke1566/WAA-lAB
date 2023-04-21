import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { redirect, useNavigate, useParams } from "react-router";
import { SelectedPostContext } from "../../context/SelectedPost";

export default function PostsDetails() {
     let param = useParams();
     let navigate = useNavigate();

   
   
    const [post, setPost] = useState({
        title: "",
        author: "",
        content: "",
    });
    

    let getPostById = () => {
    
        axios.get("http://localhost:8080/api/v1/posts/" + param.id).then(response => {
            setPost(response.data);
            setIsSelected(selectPost.map(x => x.id).includes(response.data.id));
        }).catch(error => alert(error));
    }

    useEffect(() => {
        getPostById()
    }, [])

    let deletePost = () => {
        axios.delete("http://localhost:8080/api/v1/posts/" + param.id).then(response => {
            navigate("/posts");
        }).catch(error => {
            alert(error);
        })
    }
    const { selectPost, setSelectPost } = useContext(SelectedPostContext);
    const [isSelected, setIsSelected] = useState(false);

    let selectPostFn = () => {

        setSelectPost([...selectPost, post]);
        setIsSelected(!isSelected);

    }

    let deselectPostFn = () => {
        setSelectPost(selectPost.filter(x => x.id !== post.id));
        setIsSelected(!isSelected);
       
    }

 

    return (
        <div>
            <div>
                <label>ID:</label>
                <span>{post.id}</span>
            </div>
            <div>
                <label>title:</label>
                <span>{post.title}</span>
            </div>
            <div>
                <label>author:</label>
                <span>{post.author}</span>
            </div>
            <div>
                <label>content:</label>
                <span>{post.content}</span>

            </div>
            <button onClick={deletePost}>Delete</button>
            {!isSelected ? <button onClick={selectPostFn}>Select</button> : <button onClick={deselectPostFn}>Unselect</button>}
            <button onClick={() => { navigate("/posts") }}>Back</button>

        </div>
    );
}