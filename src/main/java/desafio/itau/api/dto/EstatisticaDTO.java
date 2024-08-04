package desafio.itau.api.dto;

import lombok.Data;

import java.util.DoubleSummaryStatistics;

@Data
public class EstatisticaDTO {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public EstatisticaDTO(DoubleSummaryStatistics doubleSummaryStatistics) {
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.min = doubleSummaryStatistics.getMin();
        this.max = doubleSummaryStatistics.getMax();
    }

    public EstatisticaDTO() {
        this.count = 0L;
        this.sum = 0.0;
        this.avg = 0.0;
        this.min = 0.0;
        this.max = 0.0;
    }
}
