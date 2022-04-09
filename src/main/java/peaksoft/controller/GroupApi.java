package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.RequestGroup;
import peaksoft.dto.response.ResponseGroup;
import peaksoft.model.Group;
import peaksoft.service.serviceImple.CourseServiceImple;
import peaksoft.service.serviceImple.GroupServiceImple;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/groups/{id}")
public class GroupApi {

    private final GroupServiceImple groupService;
    private final CourseServiceImple courseService;


    @PostMapping
    public Group saveGroups(@RequestBody Group group, @PathVariable("id") Long id) {
        group.addCourseToGroup(courseService.getCourseById(id));
        return groupService.saveGroup1(group);
    }

    @GetMapping("/get/{id1}")
    public Group getGroupByID(@PathVariable("id1") Long id) {
        return groupService.getGroupById(id);
    }

    @PutMapping("/update/{id1}")
    public ResponseGroup update(@PathVariable("id1") Long id, @RequestBody RequestGroup groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @DeleteMapping("/remove/{id1}")
    public void deleteGroupById(@PathVariable ("id1")Long id) {
        groupService.removeGroupById(id);
    }

    @GetMapping("/all")
    public List<ResponseGroup> getGroups(@RequestBody List<Group> groups) {
        return groupService.getAllGroups(groups);
    }
}
