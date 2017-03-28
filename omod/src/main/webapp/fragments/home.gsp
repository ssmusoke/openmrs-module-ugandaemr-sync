<div id="apps">
    <% if (requestFacility == true) { %>
    <a id="ugandaemrsync-get-facility-id" href="/openmrs/ugandaemrsync/getFacility.page" class="button app big">

        <i class="icon-search"></i>

        Request Facility ID
    </a>
    <% } %>

    <% if (requestFacility == false) { %>

    <a id="ugandaemrsync-sync-data" href="/openmrs/ugandaemrsync/syncData.page" class="button app big">

        <i class="icon-search"></i>

        Sync Data Page
    </a>
    <% } %>
    <% if (requestFacility == false && initialSync == true) { %>

    <a id="ugandaemrsync-generate-initial-data" href="/openmrs/ugandaemrsync/initialDataGeneration.page"
       class="button app big">

        <i class="icon-search"></i>

        Generate Initial Data
    </a>
    <% } %>
</div>