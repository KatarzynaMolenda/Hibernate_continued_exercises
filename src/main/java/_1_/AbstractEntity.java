package _1_;

import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.Visitor;
import org.dom4j.tree.AbstractNode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class AbstractEntity extends AbstractNode implements Entity {
    @CreationTimestamp
    private LocalDateTime creationDateTime = LocalDateTime.now();
    @UpdateTimestamp
    private LocalDateTime lastModificationDateTime;

        public AbstractEntity() {
        }

        public short getNodeType() {
            return ENTITY_REFERENCE_NODE;
        }

        public String getPath(Element context) {
            // From XPaths perspective, entities are included in text
            Element parent = getParent();

            return ((parent != null) && (parent != context)) ? (parent
                    .getPath(context) + "/text()") : "text()";
        }

        public String getUniquePath(Element context) {
            // From XPaths perspective, entities are included in text
            Element parent = getParent();

            return ((parent != null) && (parent != context)) ? (parent
                    .getUniquePath(context) + "/text()") : "text()";
        }

        public String toString() {
            return super.toString() + " [Entity: &" + getName() + ";]";
        }

        public String getStringValue() {
            return "&" + getName() + ";";
        }

        public String asXML() {
            return "&" + getName() + ";";
        }

        public void write(Writer writer) throws IOException {
            writer.write("&");
            writer.write(getName());
            writer.write(";");
        }

        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
