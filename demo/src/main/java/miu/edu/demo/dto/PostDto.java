package miu.edu.demo.dto;
import miu.edu.demo.domain.Post;
import org.modelmapper.ModelMapper;

public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;



    public PostDto(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public static PostDto from(Post post) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(post, PostDto.class);
    }
}

