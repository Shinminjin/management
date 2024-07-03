<template>
    <v-card outlined>
        <v-card-title>
            UpdateLecture
        </v-card-title>

        <v-card-text>
            <String label="LectureName" v-model="value.lectureName" :editMode="editMode"/>
            <String label="LectureMaterial" v-model="value.lectureMaterial" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateLecture"
            >
                UpdateLecture
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateLectureCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.lectureName = '';
            this.value.lectureMaterial = '';
        },
        watch: {
        },
        methods: {
            updateLecture() {
                this.$emit('updateLecture', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

