import { Route, Routes, Navigate } from "react-router";
import AddPost from "../../components/AddPost/AddPost";
import SelectedPost from "../../components/SelectedPost/SelectedPost";
import Post from "../../components/Post/Post";
import PostsDetails from "../../components/PostsDetails/PostsDetails";
import Posts from "../../components/Posts/Posts";



export default function PageRoutes(props) {
    return (
        <Routes>
            <Route path="/" element={<Navigate to="posts"/>}></Route>
            <Route path="posts">
                <Route index element={<Posts/>} />
                <Route path=":id" element={<PostsDetails />}></Route>
            </Route>

            <Route path="addposts" element={<AddPost />}></Route>
            {/* <Route path="/course" element={<Course />}></Route> */}
            <Route path="selected" element={<SelectedPost />}></Route>

        </Routes>
    );
}


{/* <Routes>
<Route path="products" element={<Products />}>
    <Route path=":id" element={<ProductDetails />} />
</Route>

<Route path="create-product" element={<NewProductHook />} />
</Routes> */}


