import React from 'react';
const [postState, setPostState] = useState({
    title: "",
    author: "",
    content:""
  });
const PostDetails = ({ selectedPost, onEditClick, onDeleteClick }) => {
  return (
    <div className="post-details">
      <h2>Post Details</h2>
      <h3>
        <u>{selectedPost.title}</u>
      </h3>
      <p>Author: {selectedPost.author}</p>
      <p>Content: {selectedPost.content}</p>
      <button onClick={onEditClick}>Edit</button>
      <button onClick={onDeleteClick}>Delete</button>
    </div>
  );
};

export default PostDetails;
