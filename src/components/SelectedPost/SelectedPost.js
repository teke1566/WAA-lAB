import { useContext } from "react";
import { SelectedPostContext } from "../../context/SelectedPost";

export default function SelectedPost() {




    
    const { selectPost, setSelectPost } = useContext(SelectedPostContext)
 
    function unSelectPost(id){
        setSelectPost(selectPost.filter(x => x.id !== id));

    }
    let selectedPostsEle = selectPost.map(x => <div>
        <p>{x.title}</p>
        <button onClick={()=>unSelectPost(x.id)}>UnSelect</button>
        </div>);
    return selectedPostsEle;
}