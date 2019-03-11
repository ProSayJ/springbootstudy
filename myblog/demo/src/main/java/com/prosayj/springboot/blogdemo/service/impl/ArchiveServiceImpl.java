package com.prosayj.springboot.blogdemo.service.impl;

import com.prosayj.springboot.blogdemo.mapper.ArchiveMapper;
import com.prosayj.springboot.blogdemo.service.ArchiveService;
import com.prosayj.springboot.blogdemo.service.ArticleService;
import com.prosayj.springboot.blogdemo.utils.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Describe:
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveMapper archiveMapper;
    @Autowired
    ArticleService articleService;

    @Override
    public JSONObject findArchiveNameAndArticleNum() {
        List<String> archives = archiveMapper.findArchives();
        JSONArray archivesJsonArray = new JSONArray();
        JSONObject archiveJson;
        TimeUtil timeUtil = new TimeUtil();
        for(String archiveName : archives){
            archiveJson = new JSONObject();
            archiveJson.put("archiveName",archiveName);
            archiveName = timeUtil.timeYearToWhippletree(archiveName);
            archiveJson.put("archiveArticleNum",articleService.countArticleArchiveByArchive(archiveName));
            archivesJsonArray.add(archiveJson);
        }
        JSONObject returnJson = new JSONObject();
        returnJson.put("status",200);
        returnJson.put("result", archivesJsonArray);
        return returnJson;
    }

    @Override
    public void addArchiveName(String archiveName) {
        int archiveNameIsExit = archiveMapper.findArchiveNameByArchiveName(archiveName);
        if(archiveNameIsExit == 0){
            archiveMapper.addArchiveName(archiveName);
        }
    }

}
