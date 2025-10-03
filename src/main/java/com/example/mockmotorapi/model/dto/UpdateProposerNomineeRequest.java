package com.example.mockmotorapi.model.dto;

import com.example.mockmotorapi.model.NomineeDetailsDto;
import com.example.mockmotorapi.model.ProposerDetailsDto;

public record UpdateProposerNomineeRequest(
        ProposerDetailsDto proposer,
        NomineeDetailsDto nominee
) {}
