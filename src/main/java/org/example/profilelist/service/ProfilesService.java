package org.example.profilelist.service;

import jakarta.transaction.Transactional;
import org.example.profilelist.entity.Profiles;
import org.example.profilelist.repository.ProfilesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilesService {

    private final ProfilesRepository profilesRepository;

    public ProfilesService(ProfilesRepository profilesRepository) {
        this.profilesRepository = profilesRepository;
    }

    public Profiles createProfiles(Profiles profiles) {
        return profilesRepository.save(profiles);
    }

    @Transactional
    public Profiles updateProfiles(Long id, Profiles profile) {
        Profiles existing = profilesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        existing.setName(profile.getName());
        existing.setTeam(profile.getTeam());
        existing.setJob(profile.getJob());
        existing.setPhone(profile.getPhone());
        existing.setEmail(profile.getEmail());
        existing.setImage(profile.getImage());

        return existing;
    }

    public List<Profiles> findAll() {
        return profilesRepository.findAll();
    }

    public Profiles findById(Long id) {
        return profilesRepository.findById(id).orElse(null);
    }

    public void deleteProfiles(Long id) {
        profilesRepository.deleteById(id);
    }
}
