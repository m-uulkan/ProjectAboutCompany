package peaksoft.service;

import peaksoft.dto.RequestGroup;
import peaksoft.dto.response.ResponseGroup;
import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    Group saveGroup1(Group group);
    ResponseGroup updateGroup(Long id,RequestGroup requestGroup);
    List<ResponseGroup> getAllGroups(List<Group>groups);
    Group getGroupById(Long id);
    void removeGroupById(Long id);
}
