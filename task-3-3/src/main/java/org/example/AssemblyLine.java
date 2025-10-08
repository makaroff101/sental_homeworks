package org.example;

public class AssemblyLine implements IAssemblyLine {
    private ILineStep firstStep;
    private ILineStep secondStep;
    private ILineStep thirdStep;

    public AssemblyLine(ILineStep firstStep, ILineStep secondStep, ILineStep thirdStep) {
        this.firstStep = firstStep;
        this.secondStep = secondStep;
        this.thirdStep = thirdStep;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("Начало сборки продукта");

        IProductPart part1 = firstStep.buildProductPart();
        IProductPart part2 = secondStep.buildProductPart();
        IProductPart part3 = thirdStep.buildProductPart();

        product.installFirstPart(part1);
        product.installSecondPart(part2);
        product.installThirdPart(part3);

        System.out.println("Сборка завершена");
        return product;
    }
}