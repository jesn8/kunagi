









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.DaoGenerator










package scrum.server.project;

import java.util.*;
import ilarkesto.auth.*;
import ilarkesto.logging.*;
import ilarkesto.base.time.*;
import ilarkesto.base.*;
import ilarkesto.fp.*;
import ilarkesto.persistence.*;

public abstract class GProjectDao
            extends ilarkesto.persistence.ADao<Project> {

    public final String getEntityName() {
        return Project.TYPE;
    }

    public final Class getEntityClass() {
        return Project.class;
    }

    // --- clear caches ---
    public void clearCaches() {
        projectsByLabelCache.clear();
        labelsCache = null;
        projectsByScrumMasterCache.clear();
        scrumMastersCache = null;
        projectsByEndCache.clear();
        endsCache = null;
        projectsByDescriptionCache.clear();
        descriptionsCache = null;
        projectsByNextSprintCache.clear();
        nextSprintsCache = null;
        projectsByProductOwnerCache.clear();
        productOwnersCache = null;
        projectsByAdminCache.clear();
        adminsCache = null;
        projectsByTeamMemberCache.clear();
        teamMembersCache = null;
        projectsByCurrentSprintCache.clear();
        currentSprintsCache = null;
        projectsByBeginCache.clear();
        beginsCache = null;
    }

    @Override
    public void entityDeleted(EntityEvent event) {
        super.entityDeleted(event);
        if (event.getEntity() instanceof Project) {
            clearCaches();
        }
    }

    @Override
    public void entitySaved(EntityEvent event) {
        super.entitySaved(event);
        if (event.getEntity() instanceof Project) {
            clearCaches();
        }
    }

    // -----------------------------------------------------------
    // - label
    // -----------------------------------------------------------

    private final Cache<java.lang.String,Set<Project>> projectsByLabelCache = new Cache<java.lang.String,Set<Project>>(
            new Cache.Factory<java.lang.String,Set<Project>>() {
                public Set<Project> create(java.lang.String label) {
                    return getEntities(new IsLabel(label));
                }
            });

    public final Set<Project> getProjectsByLabel(java.lang.String label) {
        return projectsByLabelCache.get(label);
    }
    private Set<java.lang.String> labelsCache;

    public final Set<java.lang.String> getLabels() {
        if (labelsCache == null) {
            labelsCache = new HashSet<java.lang.String>();
            for (Project e : getEntities()) {
                if (e.isLabelSet()) labelsCache.add(e.getLabel());
            }
        }
        return labelsCache;
    }

    private static class IsLabel implements Predicate<Project> {

        private java.lang.String value;

        public IsLabel(java.lang.String value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isLabel(value);
        }

    }

    // -----------------------------------------------------------
    // - scrumMaster
    // -----------------------------------------------------------

    private final Cache<scrum.server.admin.User,Set<Project>> projectsByScrumMasterCache = new Cache<scrum.server.admin.User,Set<Project>>(
            new Cache.Factory<scrum.server.admin.User,Set<Project>>() {
                public Set<Project> create(scrum.server.admin.User scrumMaster) {
                    return getEntities(new IsScrumMaster(scrumMaster));
                }
            });

    public final Set<Project> getProjectsByScrumMaster(scrum.server.admin.User scrumMaster) {
        return projectsByScrumMasterCache.get(scrumMaster);
    }
    private Set<scrum.server.admin.User> scrumMastersCache;

    public final Set<scrum.server.admin.User> getScrumMasters() {
        if (scrumMastersCache == null) {
            scrumMastersCache = new HashSet<scrum.server.admin.User>();
            for (Project e : getEntities()) {
                if (e.isScrumMasterSet()) scrumMastersCache.add(e.getScrumMaster());
            }
        }
        return scrumMastersCache;
    }

    private static class IsScrumMaster implements Predicate<Project> {

        private scrum.server.admin.User value;

        public IsScrumMaster(scrum.server.admin.User value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isScrumMaster(value);
        }

    }

    // -----------------------------------------------------------
    // - end
    // -----------------------------------------------------------

    private final Cache<ilarkesto.base.time.Date,Set<Project>> projectsByEndCache = new Cache<ilarkesto.base.time.Date,Set<Project>>(
            new Cache.Factory<ilarkesto.base.time.Date,Set<Project>>() {
                public Set<Project> create(ilarkesto.base.time.Date end) {
                    return getEntities(new IsEnd(end));
                }
            });

    public final Set<Project> getProjectsByEnd(ilarkesto.base.time.Date end) {
        return projectsByEndCache.get(end);
    }
    private Set<ilarkesto.base.time.Date> endsCache;

    public final Set<ilarkesto.base.time.Date> getEnds() {
        if (endsCache == null) {
            endsCache = new HashSet<ilarkesto.base.time.Date>();
            for (Project e : getEntities()) {
                if (e.isEndSet()) endsCache.add(e.getEnd());
            }
        }
        return endsCache;
    }

    private static class IsEnd implements Predicate<Project> {

        private ilarkesto.base.time.Date value;

        public IsEnd(ilarkesto.base.time.Date value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isEnd(value);
        }

    }

    // -----------------------------------------------------------
    // - description
    // -----------------------------------------------------------

    private final Cache<java.lang.String,Set<Project>> projectsByDescriptionCache = new Cache<java.lang.String,Set<Project>>(
            new Cache.Factory<java.lang.String,Set<Project>>() {
                public Set<Project> create(java.lang.String description) {
                    return getEntities(new IsDescription(description));
                }
            });

    public final Set<Project> getProjectsByDescription(java.lang.String description) {
        return projectsByDescriptionCache.get(description);
    }
    private Set<java.lang.String> descriptionsCache;

    public final Set<java.lang.String> getDescriptions() {
        if (descriptionsCache == null) {
            descriptionsCache = new HashSet<java.lang.String>();
            for (Project e : getEntities()) {
                if (e.isDescriptionSet()) descriptionsCache.add(e.getDescription());
            }
        }
        return descriptionsCache;
    }

    private static class IsDescription implements Predicate<Project> {

        private java.lang.String value;

        public IsDescription(java.lang.String value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isDescription(value);
        }

    }

    // -----------------------------------------------------------
    // - nextSprint
    // -----------------------------------------------------------

    private final Cache<scrum.server.sprint.Sprint,Set<Project>> projectsByNextSprintCache = new Cache<scrum.server.sprint.Sprint,Set<Project>>(
            new Cache.Factory<scrum.server.sprint.Sprint,Set<Project>>() {
                public Set<Project> create(scrum.server.sprint.Sprint nextSprint) {
                    return getEntities(new IsNextSprint(nextSprint));
                }
            });

    public final Set<Project> getProjectsByNextSprint(scrum.server.sprint.Sprint nextSprint) {
        return projectsByNextSprintCache.get(nextSprint);
    }
    private Set<scrum.server.sprint.Sprint> nextSprintsCache;

    public final Set<scrum.server.sprint.Sprint> getNextSprints() {
        if (nextSprintsCache == null) {
            nextSprintsCache = new HashSet<scrum.server.sprint.Sprint>();
            for (Project e : getEntities()) {
                if (e.isNextSprintSet()) nextSprintsCache.add(e.getNextSprint());
            }
        }
        return nextSprintsCache;
    }

    private static class IsNextSprint implements Predicate<Project> {

        private scrum.server.sprint.Sprint value;

        public IsNextSprint(scrum.server.sprint.Sprint value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isNextSprint(value);
        }

    }

    // -----------------------------------------------------------
    // - productOwner
    // -----------------------------------------------------------

    private final Cache<scrum.server.admin.User,Set<Project>> projectsByProductOwnerCache = new Cache<scrum.server.admin.User,Set<Project>>(
            new Cache.Factory<scrum.server.admin.User,Set<Project>>() {
                public Set<Project> create(scrum.server.admin.User productOwner) {
                    return getEntities(new IsProductOwner(productOwner));
                }
            });

    public final Set<Project> getProjectsByProductOwner(scrum.server.admin.User productOwner) {
        return projectsByProductOwnerCache.get(productOwner);
    }
    private Set<scrum.server.admin.User> productOwnersCache;

    public final Set<scrum.server.admin.User> getProductOwners() {
        if (productOwnersCache == null) {
            productOwnersCache = new HashSet<scrum.server.admin.User>();
            for (Project e : getEntities()) {
                if (e.isProductOwnerSet()) productOwnersCache.add(e.getProductOwner());
            }
        }
        return productOwnersCache;
    }

    private static class IsProductOwner implements Predicate<Project> {

        private scrum.server.admin.User value;

        public IsProductOwner(scrum.server.admin.User value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isProductOwner(value);
        }

    }

    // -----------------------------------------------------------
    // - admins
    // -----------------------------------------------------------

    private final Cache<scrum.server.admin.User,Set<Project>> projectsByAdminCache = new Cache<scrum.server.admin.User,Set<Project>>(
            new Cache.Factory<scrum.server.admin.User,Set<Project>>() {
                public Set<Project> create(scrum.server.admin.User admin) {
                    return getEntities(new ContainsAdmin(admin));
                }
            });

    public final Set<Project> getProjectsByAdmin(scrum.server.admin.User admin) {
        return projectsByAdminCache.get(admin);
    }
    private Set<scrum.server.admin.User> adminsCache;

    public final Set<scrum.server.admin.User> getAdmins() {
        if (adminsCache == null) {
            adminsCache = new HashSet<scrum.server.admin.User>();
            for (Project e : getEntities()) {
                adminsCache.addAll(e.getAdmins());
            }
        }
        return adminsCache;
    }

    private static class ContainsAdmin implements Predicate<Project> {

        private scrum.server.admin.User value;

        public ContainsAdmin(scrum.server.admin.User value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.containsAdmin(value);
        }

    }

    // -----------------------------------------------------------
    // - teamMembers
    // -----------------------------------------------------------

    private final Cache<scrum.server.admin.User,Set<Project>> projectsByTeamMemberCache = new Cache<scrum.server.admin.User,Set<Project>>(
            new Cache.Factory<scrum.server.admin.User,Set<Project>>() {
                public Set<Project> create(scrum.server.admin.User teamMember) {
                    return getEntities(new ContainsTeamMember(teamMember));
                }
            });

    public final Set<Project> getProjectsByTeamMember(scrum.server.admin.User teamMember) {
        return projectsByTeamMemberCache.get(teamMember);
    }
    private Set<scrum.server.admin.User> teamMembersCache;

    public final Set<scrum.server.admin.User> getTeamMembers() {
        if (teamMembersCache == null) {
            teamMembersCache = new HashSet<scrum.server.admin.User>();
            for (Project e : getEntities()) {
                teamMembersCache.addAll(e.getTeamMembers());
            }
        }
        return teamMembersCache;
    }

    private static class ContainsTeamMember implements Predicate<Project> {

        private scrum.server.admin.User value;

        public ContainsTeamMember(scrum.server.admin.User value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.containsTeamMember(value);
        }

    }

    // -----------------------------------------------------------
    // - currentSprint
    // -----------------------------------------------------------

    private final Cache<scrum.server.sprint.Sprint,Set<Project>> projectsByCurrentSprintCache = new Cache<scrum.server.sprint.Sprint,Set<Project>>(
            new Cache.Factory<scrum.server.sprint.Sprint,Set<Project>>() {
                public Set<Project> create(scrum.server.sprint.Sprint currentSprint) {
                    return getEntities(new IsCurrentSprint(currentSprint));
                }
            });

    public final Set<Project> getProjectsByCurrentSprint(scrum.server.sprint.Sprint currentSprint) {
        return projectsByCurrentSprintCache.get(currentSprint);
    }
    private Set<scrum.server.sprint.Sprint> currentSprintsCache;

    public final Set<scrum.server.sprint.Sprint> getCurrentSprints() {
        if (currentSprintsCache == null) {
            currentSprintsCache = new HashSet<scrum.server.sprint.Sprint>();
            for (Project e : getEntities()) {
                if (e.isCurrentSprintSet()) currentSprintsCache.add(e.getCurrentSprint());
            }
        }
        return currentSprintsCache;
    }

    private static class IsCurrentSprint implements Predicate<Project> {

        private scrum.server.sprint.Sprint value;

        public IsCurrentSprint(scrum.server.sprint.Sprint value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isCurrentSprint(value);
        }

    }

    // -----------------------------------------------------------
    // - begin
    // -----------------------------------------------------------

    private final Cache<ilarkesto.base.time.Date,Set<Project>> projectsByBeginCache = new Cache<ilarkesto.base.time.Date,Set<Project>>(
            new Cache.Factory<ilarkesto.base.time.Date,Set<Project>>() {
                public Set<Project> create(ilarkesto.base.time.Date begin) {
                    return getEntities(new IsBegin(begin));
                }
            });

    public final Set<Project> getProjectsByBegin(ilarkesto.base.time.Date begin) {
        return projectsByBeginCache.get(begin);
    }
    private Set<ilarkesto.base.time.Date> beginsCache;

    public final Set<ilarkesto.base.time.Date> getBegins() {
        if (beginsCache == null) {
            beginsCache = new HashSet<ilarkesto.base.time.Date>();
            for (Project e : getEntities()) {
                if (e.isBeginSet()) beginsCache.add(e.getBegin());
            }
        }
        return beginsCache;
    }

    private static class IsBegin implements Predicate<Project> {

        private ilarkesto.base.time.Date value;

        public IsBegin(ilarkesto.base.time.Date value) {
            this.value = value;
        }

        public boolean test(Project e) {
            return e.isBegin(value);
        }

    }

    // --- valueObject classes ---
    @Override
    protected Set<Class> getValueObjectClasses() {
        Set<Class> ret = new HashSet<Class>(super.getValueObjectClasses());
        return ret;
    }

    @Override
    public Map<String, Class> getAliases() {
        Map<String, Class> aliases = new HashMap<String, Class>(super.getAliases());
        return aliases;
    }

    // --- dependencies ---

    protected scrum.server.sprint.SprintDao sprintDao;

    public void setSprintDao(scrum.server.sprint.SprintDao sprintDao) {
        this.sprintDao = sprintDao;
    }

}
