package peaksoft.mapper;


import org.springframework.stereotype.Component;

import peaksoft.dto.RequestGroup;

import peaksoft.dto.response.ResponseCourse;
import peaksoft.dto.response.ResponseGroup;
import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper {

    public Group create(RequestGroup requestGroup) {
        Group group = new Group();
        group.setNameGroup(requestGroup.getNameGroup());
        group.setDateOfStart(requestGroup.getDateOfStart());
        group.setDateOfFinish(requestGroup.getDateOfFinish());
        return group;
    }


    public ResponseGroup viewGroup(Group group){
        ResponseGroup groupResponse=new ResponseGroup();
        if(group.getId() !=null){
            groupResponse.setId(String.valueOf(group.getId()));
        }
        groupResponse.setNameGroup(group.getNameGroup());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        return groupResponse;
    }

    public void update(Group group, RequestGroup requestGroup) {
        group.setNameGroup(requestGroup.getNameGroup());
        group.setDateOfStart(requestGroup.getDateOfStart());
        group.setDateOfFinish(requestGroup.getDateOfFinish());
    }
    public List<ResponseGroup> viewGroups(List<Group> groupList) {
        List<ResponseGroup>responses=new ArrayList<>();
        for(Group g:groupList){
            responses.add(viewGroup(g));
        }
        return responses;
    }
}


