import React, { useState } from 'react';
import Posts from './Posts';
import './index.css';
const Dashboard = () => {
  const [posts, setPosts] = useState([
    { id: 111, title: 'Happiness', author: 'John',  content: 'This is the content in the post...' },
    { id: 112, title: 'MIU', author: 'Dean', content: 'This is the content in the post...' },
    { id: 113, title: 'Enjoy Life', author: 'Jasmine',  content: 'This is the content in the post...' }
  ]);
  const [selectedPost, setSelectedPost] = useState(null);
  const [updatedTitle, setUpdatedTitle] = useState('');

  const PostClick = (post) => {
    setSelectedPost(post);
  }

  const UpdateTitle = () => {
    const updatedPosts = posts.map(post => {
      if (post.id === selectedPost.id) {
        return { post, title: updatedTitle };
      }
      return post;
    });
    setPosts(updatedPosts);
  }

  const EditButton = () => {
    console.log('Edit Button for post:', selectedPost);
  }

  const DeleteButton = () => {
    console.log('Delete Button for post:', selectedPost);
    const updatedPosts = posts.filter(post => post.id !== selectedPost.id);
    setPosts(updatedPosts);
    setSelectedPost(null);
  }

  return (
    <div className="container">
      <h1>Dashboard</h1>
      <Posts posts={posts} onPostClick={PostClick} />
      {selectedPost && (
        <div className="post-details">
          <h2>Post Details</h2>
         
          <h3><u>{selectedPost.title}</u></h3>

          <p>Author: {selectedPost.author}</p>
          <p>Content: {selectedPost.content}</p>
          <button onClick={EditButton}>Edit</button>
          <button onClick={DeleteButton}>Delete</button>
        </div>
      )}
      <input
        type="text"
        value={updatedTitle}
        onChange={(e) => setUpdatedTitle(e.target.value)}
      />
      <button onClick={UpdateTitle}>Change Name</button>
    </div>
  );
}

export default Dashboard;
