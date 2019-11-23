package com.nfdw.core.converVideo;

public class Contants {
    /**
     * @Description:(3.工具类主类)设置转码工具的各个路径
     * @param:@param args
     * @return:void
     * @author:Zoutao
     * @date:2018-6-22
     * @version:V1.0
     */

    public static final String ffmpegpath = "F:/ffmpeg-20161227-0ff8c6b-win32-static/bin/ffmpeg.exe";		// ffmpeg工具安装位置
    public static final String mencoderpath = "F:/ffmpeg/bin/mencoder"; 	// mencoder工具安装的位置

    public static final String videofolder = "E://Projectpicture/websiteimages/temp/"; 	// 需要被转换格式的视频目录
    public static final String videoRealPath = "E://Projectpicture/websiteimages/temp/"; 	// 需要被截图的视频目录

    public static final String targetfolder = "E://Projectpicture/websiteimages/finshvideo/"; // 转码后视频保存的目录
    public static final String imageRealPath = "E://Projectpicture/websiteimages/finshimg/"; // 截图的存放目录
}
