package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.RequestGroup;
import peaksoft.dto.response.ResponseGroup;
import peaksoft.mapper.GroupMapper;
import peaksoft.model.Group;
import peaksoft.repository.GroupRepository;
import peaksoft.service.GroupService;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImple implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;


    @Override
    public ResponseGroup updateGroup(Long id, RequestGroup requestGroup) {
        Group group=groupRepository.findById(id).get();
        groupMapper.update(group,requestGroup);
        return groupMapper.viewGroup(groupRepository.save(group));

    }

    @Override
    public List<ResponseGroup> getAllGroups(List<Group> groups) {
        List<Group>groupList=groupRepository.findAll();
        return groupMapper.viewGroups(groupList) ;
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void removeGroupById(Long id) {
       Group group=groupRepository.findById(id).get();
       groupRepository.deleteById(id);
       groupMapper.viewGroup(group);
    }
    @Override
    public Group saveGroup1(Group group) {
        return groupRepository.save(group);
    }

}
