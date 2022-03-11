package thread.demo01;

import lombok.Data;
import thread.project.QyjAuditCalculationDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Task1 implements Runnable{
    private List<QyjAuditCalculationDTO> list;
    private long start;
    private long start2;

    public Task1(List<QyjAuditCalculationDTO> list,long start,long start2)
    {
        this.list=list;
        this.start=start;
        this.start2=start2;
    }

    @Override
    public void run() {
        // 销售收入排名,得分
        proceedsSale(list,start,start2);
    }
    // 销售收入排名,得分
    public static void proceedsSale(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS,long start,long start2) {
        //销售收入排名,得分
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getProceedsSale).reversed()).collect(Collectors.toList());
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
            for (int i = 0; i < totalTaxRandList.size(); i++) {
                System.out.println("proceedsSale"+i);
            }

            long end=System.currentTimeMillis();
            System.out.println("proceedsSale"+"-"+"end"+"共耗时"+(end-start)+"毫秒");
            System.out.println("proceedsSale"+"-"+"end"+"共耗时"+(end-start2)+"毫秒");
        });

    }
}
