package com.example.mockmotorapi.api;

import com.example.mockmotorapi.model.*;
import com.example.mockmotorapi.model.dto.InitiateApplicationRequest;
import com.example.mockmotorapi.model.dto.InitiateApplicationResponse;
import com.example.mockmotorapi.model.dto.PickQuoteRequest;
import com.example.mockmotorapi.model.dto.UpdateProposerNomineeRequest;
import com.example.mockmotorapi.model.enums.ApplicationStatus;
import com.example.mockmotorapi.model.enums.EngineCapacityUnit;
import com.example.mockmotorapi.model.enums.FuelType;
import com.example.mockmotorapi.model.enums.PaymentState;
import com.example.mockmotorapi.model.enums.PolicyStatus;
import com.example.mockmotorapi.model.enums.ProposalStatus;
import com.example.mockmotorapi.model.enums.QuoteState;
import com.example.mockmotorapi.model.enums.Sex;
import com.example.mockmotorapi.model.enums.TimePeriodUnit;
import com.example.mockmotorapi.model.enums.VehicleType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @PostMapping("/application/initiate")
    public ResponseEntity<GenericResponse<InitiateApplicationResponse>> initiateApplication(@RequestBody InitiateApplicationRequest request) {
        // Build mock quote response
        PaymentDetailResponse monthly = new PaymentDetailResponse(new BigDecimal("1000"), new BigDecimal("50"), new BigDecimal("0"), new BigDecimal("171"), new BigDecimal("1121"));
        PaymentDetailResponse yearly = new PaymentDetailResponse(new BigDecimal("11000"), new BigDecimal("500"), new BigDecimal("0"), new BigDecimal("1872"), new BigDecimal("12372"));

        PremiumResponse premiumResponse = new PremiumResponse(new BigDecimal("0"), new BigDecimal("500000"), new PaymentOptions(monthly, yearly));

        QuoteResponse quote = new QuoteResponse(
                "Q-001",
                "P-001",
                false,
                new BigDecimal("500000"),
                List.of(premiumResponse),
                "560001",
                new TimePeriod(TimePeriodUnit.YEAR, 1),
                List.of(new AddOnDetail("AD-1", "Roadside Assistance", "24x7 support", new BigDecimal("500"), false, monthly)),
                LocalDateTime.now()
        );

        MotorAssetAttributes asset = new MotorAssetAttributes(
                null,
                "KA-01",
                request.registrationNumber(),
                "Maruti",
                "Swift",
                "VXI",
                null,
                List.of(FuelType.PETROL),
                3,
                VehicleType.CAR,
                5,
                new EngineCapacity(1197.0, EngineCapacityUnit.CC),
                new Metric<>(900.0, "KG"),
                LocalDate.now().plusYears(1),
                false,
                false,
                "Bengaluru"
        );

        InitiateApplicationResponse data = new InitiateApplicationResponse(
                "APP-001",
                ApplicationStatus.PENDING,
                asset,
                List.of(quote),
                LocalDateTime.now().plusMinutes(30)
        );

        return ResponseEntity.ok(GenericResponse.success(200, "Application created successfully", data));
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<GenericResponse<InsuranceApplication>> getApplication(@PathVariable String applicationId) {
        InsuranceApplication app = sampleApplication(applicationId);
        return ResponseEntity.ok(GenericResponse.success(200, "Application retrieved successfully", app));
    }

    @PostMapping("/application/{applicationId}")
    public ResponseEntity<GenericResponse<InsuranceApplication>> pickQuote(@PathVariable String applicationId,
                                                                           @RequestBody PickQuoteRequest request) {
        InsuranceApplication app = sampleApplication(applicationId);
        return ResponseEntity.ok(GenericResponse.success(200, "Quote selected successfully", app));
    }

    @PatchMapping("/application/{applicationId}")
    public ResponseEntity<GenericResponse<InsuranceApplication>> updateProposerAndNominee(@PathVariable String applicationId,
                                                                                           @RequestBody UpdateProposerNomineeRequest request) {
        InsuranceApplication app = sampleApplication(applicationId);
        app = app.withProposerDetails(request.proposer())
                 .withNomineeDetails(request.nominee());
        return ResponseEntity.ok(GenericResponse.success(200, "Nominee and proposer details updated successfully", app));
    }

    @PostMapping("/application/{applicationId}/kyc/initiate")
    public ResponseEntity<GenericResponse<Map<String, String>>> initiateKyc(@PathVariable String applicationId) {
        return ResponseEntity.ok(GenericResponse.success(200, "KYC initiation successful", Map.of("startKycUrl", "https://demo.local/kyc/start?app=" + applicationId)));
    }

    @PostMapping("/application/{applicationId}/payment")
    public ResponseEntity<GenericResponse<PaymentInitiationResponse>> initiatePayment(@PathVariable String applicationId) {
        PaymentInitiationResponse data = new PaymentInitiationResponse(
                applicationId,
                "https://pay.local/redirect/ORDER-123",
                new AmountContract(new BigDecimal("12372.00"), "INR"),
                LocalDate.now()
        );
        return ResponseEntity.ok(GenericResponse.success(200, "Payment initiated successfully", data));
    }

    private InsuranceApplication sampleApplication(String applicationId) {
        ProposerDetailsDto proposer = new ProposerDetailsDto(
                "John Doe",
                LocalDate.of(1990, 1, 1),
                Sex.MALE,
                "+911234567890",
                "john@example.com",
                new AddressDetails(null, "Line 1", "Line 2", "560001", "Bengaluru", "Karnataka")
        );

        ApplicationAssetInfoDto appAssetInfo = new ApplicationAssetInfoDto(
                applicationId,
                "AAI-1",
                Map.of(
                        "PRIMARY", new AssetAttributes(false, true, true, true, null, "BASE-1", true)
                )
        );
        AssetDetailsDto assetDetailsDto = new AssetDetailsDto(appAssetInfo);

        PaymentDetails paymentDetails = new PaymentDetails(
                PaymentState.PENDING,
                List.of(new PaymentTransaction(PaymentState.PENDING, "Q-001", "PAY-123", LocalDateTime.now(), new BigDecimal("0"), "INST-1")),
                false
        );

        QuoteDetails quoteDetails = new QuoteDetails("Q-001", QuoteState.PENDING, "P-001", true);
        PolicyApplicationData policyData = new PolicyApplicationData(PolicyStatus.PENDING, "POL-001");

        PremiumResponse premiumResponse = new PremiumResponse(new BigDecimal("0"), new BigDecimal("500000"), new PaymentOptions(
                new PaymentDetailResponse(new BigDecimal("1000"), new BigDecimal("50"), new BigDecimal("0"), new BigDecimal("171"), new BigDecimal("1121")),
                new PaymentDetailResponse(new BigDecimal("11000"), new BigDecimal("500"), new BigDecimal("0"), new BigDecimal("1872"), new BigDecimal("12372"))
        ));
        QuoteResponse response = new QuoteResponse(
                "Q-001",
                "P-001",
                false,
                new BigDecimal("500000"),
                List.of(premiumResponse),
                "560001",
                new TimePeriod(TimePeriodUnit.YEAR, 1),
                List.of(new AddOnDetail("AD-1", "Roadside Assistance", "24x7 support", new BigDecimal("500"), false, new PaymentDetailResponse(new BigDecimal("500"), BigDecimal.ZERO, BigDecimal.ZERO, new BigDecimal("90"), new BigDecimal("590")))),
                LocalDateTime.now()
        );

        ProposalResponse proposal = new ProposalResponse("P-001", "MOTOR", "PRD-1", ProposalStatus.DRAFT,
                List.of(new AssetUWResponse("ASSET-1", "OK", null, null, null)),
                List.of(), LocalDateTime.now());

        ProposalDetailResponse proposalDetail = new ProposalDetailResponse(List.of(response), proposal);

        NomineeDetailsDto nominee = new NomineeDetailsDto("Jane Doe", "SPOUSE", "1992-02-02", "+919876543210");

        return new InsuranceApplication(
                applicationId,
                ApplicationStatus.PENDING,
                proposer,
                assetDetailsDto,
                paymentDetails,
                quoteDetails,
                policyData,
                proposalDetail,
                "560001",
                nominee
        );
    }
}
