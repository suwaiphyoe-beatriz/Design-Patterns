public class DocumentProxy implements DocumentInterface {
    private Document realDocument;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public String getContent(User user) {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate(); // no restriction
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }
}