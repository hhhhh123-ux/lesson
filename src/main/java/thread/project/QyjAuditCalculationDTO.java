package thread.project;

import lombok.Data;


@Data
public class QyjAuditCalculationDTO implements Runnable {

    private String baseId;

    /**
     * 纳税总额
     */
    private double totalTax;

    /**
     * 销售收入
     */
    private double proceedsSale;

    /**
     * 在职人员数
     */
    private double serviceOfficer;

    /**
     * 研发投入额
     */
    private double investment;

    /**
     * 研发投入占比
     */
    private double proportionInvestment;


    @Override
    public void run() {

    }
}
