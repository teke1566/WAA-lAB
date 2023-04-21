import axios from "axios";
import { useState, useRef } from "react";
import { Navigate, useNavigate } from "react-router";
import './AddPost.css';

const AddPost = (props) => {
  const form = useRef();
  const [title, setTitle] = useState(""); 
  const [author, setAuthor] = useState(""); 
  const [content, setContent] = useState(""); 

  let navigate = useNavigate();

  let savePost = (event) => {
    event.preventDefault(); // Prevent the default form submission behavior

    // Get form data from the ref and the state variables
    let formData = form.current;
    let title = formData['title'].value;
    let author = formData['author'].value;
    let content = formData['content'].value;

    // Send a POST request to the API with the data
    axios.post("http://localhost:8080/api/v1/posts", {
        title: title,
        author: author,
        content: content
    })
    .then(response => {
        console.log(response.data);
        navigate("/posts"); // Navigate to the posts page after successful submission
    })
    .catch(err => {
        console.error(err);
        alert("Error adding post."); // Display an error message if the request fails
    })
  }

  let handleTitleChange = (event) => {
    setTitle(event.target.value); 
  }

  let handleAuthorChange = (event) => {
    setAuthor(event.target.value); 
  }

  let handleContentChange = (event) => {
    setContent(event.target.value); 
  }

  return (
    <div className="NewProduct">
      <h2>Create a New Post</h2>
      <form onSubmit={savePost} ref={form}>
        <div>
          <input type="text" name="title" placeholder="Title" value={title} onChange={handleTitleChange} />
        </div>
        <div>
          <input type="text" name="author" placeholder="Author" value={author} onChange={handleAuthorChange} />
        </div>
        <div>
          <textarea name="content" value={content} onChange={handleContentChange} />
        </div>
        <button type="submit">Add post</button>
      </form>
    </div>
  );
}

export default AddPost;
