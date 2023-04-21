import axios from "axios";
import { useEffect, useRef, useState } from "react";
import Post from "../Post/Post";

export default function Posts() {
    const [criteria, setCriteria] = useState();
    const [search, setSearch] = useState();



    const [postList, setPostList] = useState([]);
    
    let getPosts = () => {

        axios.get("http://localhost:8080/api/v1/posts").then(response => {
            setPostList(response.data);
        }).catch(error => {
            alert(error);
        })

    }
    useEffect(() => { getPosts() }, [])  
    

    let searchPost = () => {
        if (criteria !== null && criteria !== 0 && search !== null && search !== "") {
            axios.get("http://localhost:8080/api/v1/posts", {
                params: {
                    filter: criteria,
                    input: search
                }
            }).then(response => {
                setPostList(response.data);
            }).catch(error => {
                alert(error);
            })
        } else {
            alert("Search parameters cannot be empty");
        }
    }

    const postsElement = postList.map(x => <Post model={x} />)

    

    return (
        <div>
            <div>
                <label>Filter</label>
                <select onChange={(e) => { setCriteria(e.target.value) }}>
                    <option value={null}>N/A</option>
                    <option value={'author'}>Author</option>
                </select>

                <label>Input: </label>
                <input type="text" value={search} onChange={(e) => setSearch(e.target.value)} />

                <button onClick={searchPost}>Apply Filter</button>

                <div>
                    {postsElement}
                </div>
            </div>
        </div>
    );
}