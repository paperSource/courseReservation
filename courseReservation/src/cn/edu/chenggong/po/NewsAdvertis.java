package cn.edu.chenggong.po;

public class NewsAdvertis {
private String newsName;
private String newsPath;
private String advertisName;
private String advertisPath;
private int newsAdverId;
public String getNewsName() {
	return newsName;
}
public void setNewsName(String newsName) {
	this.newsName = newsName;
}
public String getNewsPath() {
	return newsPath;
}
public void setNewsPath(String newsPath) {
	this.newsPath = newsPath;
}
public String getAdvertisName() {
	return advertisName;
}
public void setAdvertisName(String advertisName) {
	this.advertisName = advertisName;
}
public String getAdvertisPath() {
	return advertisPath;
}
public void setAdvertisPath(String advertisPath) {
	this.advertisPath = advertisPath;
}

public int getNewsAdverId() {
	return newsAdverId;
}
public void setNewsAdverId(int newsAdverId) {
	this.newsAdverId = newsAdverId;
}
@Override
public String toString() {
	return "NewsAdvertis [newsName=" + newsName + ", newsPath=" + newsPath
			+ ", advertisName=" + advertisName + ", advertisPath="
			+ advertisPath + ", newsAdverId=" + newsAdverId + "]";
}
}
