<template>

    <v-data-table
        :headers="headers"
        :items="lectureInquiry"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'LectureInquiryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            lectureInquiry : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/lectureInquiries'))

            temp.data._embedded.lectureInquiries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.lectureInquiry = temp.data._embedded.lectureInquiries;
        },
        methods: {
        }
    }
</script>

