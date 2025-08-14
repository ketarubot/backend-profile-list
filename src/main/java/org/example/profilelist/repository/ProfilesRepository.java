package org.example.profilelist.repository;

import org.example.profilelist.entity.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {
}
