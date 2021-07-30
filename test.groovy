public ArrayList<String> getEnvironments(String p_clientName) {

    ArrayList<String> res = new ArrayList<String>();

    if (!(p_clientName?.trim())){
        res.add("Select a client");
        return res;
    }

    def possibleEnvironments = yyz.getEnvironmentTypeEnum();

    def requiredLabels = [new hudson.model.labels.LabelAtom ("PRODUCT")];
    requiredLabels.add(new hudson.model.labels.LabelAtom(p_clientName.toUpperCase()));


    Jenkins.instance.computers.each { node ->
        if (node.assignedLabels.containsAll(requiredLabels)) {
                // Yes.  Let's get the environment name out of it.
                node.assignedLabels.any { al ->
                    def e = yyz.getEnvironmentFromString(al.getName(), true);
                    if (e != null) {
                        res.add(al.getName());
                        return; // this is a continue
                    }
                }
            }
        }


    return res;
}
