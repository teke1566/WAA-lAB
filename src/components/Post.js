const Post = ({ post, onClick }) => {
  return (
    <div onClick={() => onClick(post)}>
     
    </div>
  );
};

export default Post;
