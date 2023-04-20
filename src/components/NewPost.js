import React from 'react';

const NewPost = ({ title, author, content, onChange, addButtonClicked }) => {
  return (
    <div>
      <h2>Create a New Post</h2>
      <form>
        <div>
        <input type="text" name="title" placeholder="Title" value={title} onChange={onChange} />
        </div>
        
       <div>
        <input type="text" name="author" placeholder="Author" value={author} onChange={onChange} />
       </div>
       <div>
       <textarea name="content" value={content} onChange={onChange} />
       </div>
       
        <button type="button" onClick={addButtonClicked}>Add Post</button>
      </form>
    </div>
  );
}
export default NewPost;