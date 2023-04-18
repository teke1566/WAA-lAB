const Post = ({ post, onClick }) => {
  return (
    <div onClick={() => onClick(post)}>
      <h3>{post.title}</h3>
      <p>Author: {post.author}</p>
    </div>
  );
};

export default Post;
