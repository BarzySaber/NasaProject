package POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Nasa {
    private String date;
    private String title;
    private String url;
    public Nasa(){

    }

    public Nasa(String title,String date,String url){
        this.date=date;
        this.title=title;
        this.url=url;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString(){
        return "date is: "+date+"\n"+"Title is : "+title+"\n Url is : "+url;
    }
}
