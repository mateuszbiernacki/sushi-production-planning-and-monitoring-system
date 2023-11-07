package info.biernacki.sushifactorywebserver.plan;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class PlanRecord {
    private String foldingLineName;
    private String receiver;
    private String setName;
    private Integer quantity;
    private ZonedDateTime plannedStartDateTime;
    private ZonedDateTime plannedFinishDateTime;

    public PlanRecord(String foldingLineName,
                      String receiver,
                      String setName,
                      Integer quantity,
                      Integer startYear,
                      Integer startMonth,
                      Integer startDay,
                      Integer startHour,
                      Integer startMinute,
                      Integer finishYear,
                      Integer finishMonth,
                      Integer finishDay,
                      Integer finishHour,
                      Integer finishMinute){
        this.foldingLineName = foldingLineName;
        this.receiver = receiver;
        this.setName = setName;
        this.quantity = quantity;
        this.plannedFinishDateTime = ZonedDateTime.of(startYear, startMonth, startDay, startHour, startMinute,
                0, 0, ZoneId.of("UTC"));
        this.plannedStartDateTime = ZonedDateTime.of(finishYear, finishMonth, finishDay, finishHour, finishMinute,
                0, 0, ZoneId.of("UTC"));;
    }

    public String getFoldingLineName() {
        return foldingLineName;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSetName() {
        return setName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ZonedDateTime getPlannedStartDateTime() {
        return plannedStartDateTime;
    }

    public ZonedDateTime getPlannedFinishDateTime() {
        return plannedFinishDateTime;
    }

    @Override
    public String toString() {
        return "PlanRecord{" +
                "foldingLineName='" + foldingLineName + '\'' +
                ", receiver='" + receiver + '\'' +
                ", setName='" + setName + '\'' +
                ", quantity=" + quantity +
                ", plannedStartDateTime=" + plannedStartDateTime +
                ", plannedFinishDateTime=" + plannedFinishDateTime +
                '}';
    }
}
