package seedu.address.model.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.model.listing.Listing;
import seedu.address.testutil.ApplicantBuilder;
import seedu.address.testutil.ListingBuilder;

public class ListingNumberOfApplicantsComparatorTest {

    @Test
    public void compare_listingWithSameNumberOfApplicants_returnsZero() {
        Listing l1 = new ListingBuilder().withDescription("Looking for Software Developer").build();
        Listing l2 = new ListingBuilder().withDescription("Looking for Web Developer").build();
        ListingNumberOfApplicantsComparator comparator = new ListingNumberOfApplicantsComparator();
        assertEquals(0, comparator.compare(l1, l2));
    }

    @Test
    public void compare_listingWithDifferentNumberOfApplicants_returnsNegative() {
        Listing l1 = new ListingBuilder()
                .withTitle("Software Developer")
                .withApplicants(new ArrayList<>(Arrays.asList(new ApplicantBuilder().build())))
                .build();
        Listing l2 = new ListingBuilder()
                .withTitle("Web Developer")
                .withApplicants(new ArrayList<>(Arrays.asList(
                        new ApplicantBuilder().build(),
                        new ApplicantBuilder().build())))
                .build();
        ListingNumberOfApplicantsComparator comparator = new ListingNumberOfApplicantsComparator();
        int result = comparator.compare(l1, l2);
        assertEquals(true, result < 0);
    }

    @Test
    public void compare_listingWithDifferentNumberOfApplicants_returnsPositive() {
        Listing l1 = new ListingBuilder()
                .withTitle("Web Developer")
                .withApplicants(new ArrayList<>(Arrays.asList(
                        new ApplicantBuilder().build(),
                        new ApplicantBuilder().build())))
                .build();
        Listing l2 = new ListingBuilder()
                .withTitle("Software Developer")
                .withApplicants(new ArrayList<>(Arrays.asList(new ApplicantBuilder().build())))
                .build();
        ListingNumberOfApplicantsComparator comparator = new ListingNumberOfApplicantsComparator();
        int result = comparator.compare(l1, l2);
        assertEquals(true, result > 0);
    }

    @Test
    public void compare_listingWithNoApplicants_returnsZero() {
        Listing l1 = new ListingBuilder().withTitle("Web Developer").withApplicants(new ArrayList<>()).build();
        Listing l2 = new ListingBuilder().withTitle("Software Developer").withApplicants(new ArrayList<>()).build();
        ListingNumberOfApplicantsComparator comparator = new ListingNumberOfApplicantsComparator();
        int result = comparator.compare(l1, l2);
        assertEquals(0, comparator.compare(l1, l2));
    }

}
