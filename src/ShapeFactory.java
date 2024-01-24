public class ShapeFactory {
    private static ShapeFactory ins = null;
    private ShapeFactory(){}

    public static ShapeFactory getInstance() {
        if (ins == null) ins = new ShapeFactory();
        return ins;
    }
    public Shape getShape(String shapeType){
        if(shapeType == null) { return null; }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        } else if(shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        return null;
    }
}

