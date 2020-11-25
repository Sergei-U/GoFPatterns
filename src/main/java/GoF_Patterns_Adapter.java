/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Adapter {

    /**
     * Адаптер — это структурный паттерн проектирования,
     * который позволяет объектам с несовместимыми интерфейсами работать вместе.
     */

    static class DocProccer {
        //особый метод для работы с JSON, доступен только в JSON-формате
        public void runJson(JSON json) {
            System.out.println(json.getJSONText());
        }
    }

    static class JSON {
        //класс для работы с JSON

        public String getJSONText() {
            return "JSON: text";
        }
    }

    static class XML {
        //некоторый класс для работы с XML
        //который можем принимать, но программа работает только с JSON
        public String getXMLText() {
            return "XML <text>";
        }
    }

    static class XmlToJsonAdapter extends JSON {
        String strangesymblos;

        XmlToJsonAdapter(XML xml) {
            this.strangesymblos = xml.getXMLText();
        }

        public String getJSONText() {
            //Условно волшебный код
            //Превращает строку вида "XML <text>" в "JSON: text"
            // return convert(strangesymblos)
            //Ну или так =)
            return "JSON: text";
        }

    }

    public static void main(String[] args) {
        DocProccer docProccer = new DocProccer();

        //Условно полученные данные
        XML xml = new XML();
        JSON json = new JSON();

        //Адаптер
        XmlToJsonAdapter xmlToJsonAdapter = new XmlToJsonAdapter(xml);

        //Ну и работаем дальше как с JSON
        docProccer.runJson(xmlToJsonAdapter);

        docProccer.runJson(json);

    }
}
