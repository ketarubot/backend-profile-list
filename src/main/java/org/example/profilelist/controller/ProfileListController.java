package org.example.profilelist.controller;

import org.example.profilelist.entity.Profiles;
import org.example.profilelist.service.ProfilesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileListController {

    private final ProfilesService profilesService;

    public ProfileListController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @PostMapping("/api/profile")
    public Profiles addProfile(@RequestBody Profiles profiles) {
        return profilesService.createProfiles(profiles);
    }

    @PutMapping("/api/profile/{id}")
    public Profiles updateProfile(@PathVariable Long id, @RequestBody Profiles profiles) {
        return profilesService.updateProfiles(id, profiles);
    }

    @GetMapping("/api/profile/list")
    public List<Profiles> findAllProfiles() {
        return profilesService.findAll();
    }

    @GetMapping("/api/profile/{id}")
    public Profiles getProfile(@PathVariable Long id) {
        return profilesService.findById(id);
    }

    @DeleteMapping("/api/profile/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profilesService.deleteProfiles(id);
    }
}
